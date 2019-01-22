package org.castor.cpa.jpa.processors.fieldprocessors;

import static javax.persistence.TemporalType.TIMESTAMP;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;

import org.castor.cpa.jpa.info.ClassInfo;
import org.castor.cpa.jpa.info.ClassInfoBuilder;
import org.castor.cpa.jpa.info.FieldInfo;
import org.castor.cpa.jpa.natures.JPAFieldNature;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public final class JPATemporalProcessorTest {
    private JPATemporalProcessor _processor;
    private JPAFieldNature _fieldNature;
    @Mock
    private Temporal _annotation;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        _processor = new JPATemporalProcessor();
        ClassInfo classInfo = new ClassInfo();
        classInfo.addNature(JPAFieldNature.class.getCanonicalName());
        _fieldNature = new JPAFieldNature(classInfo);
    }

    @Test
    public void processorIsForTemporalAnnotation() throws Exception {
        assertEquals(Temporal.class, _processor.forAnnotationClass());
    }

    @Test
    public void processorReturnsTrueForTemporalAnnotatedClassCorrectly()
            throws Exception {
        boolean result = _processor.processAnnotation(_fieldNature, _annotation,
                TemporalAnnotatedClass.class.getDeclaredMethod("getDate"));
        assertTrue(result);
    }

    @Test
    public void processorReturnsFalseForNonAnnotatedClass() throws Exception {
        boolean result = _processor.processAnnotation(_fieldNature, _annotation,
                NonAnnotatedClass.class.getDeclaredMethod("getDate"));
        assertFalse(result);
    }

    @Test
    public void processorReturnsFalseForOtherwiseAnnotatedClass()
            throws Exception {
        boolean result = _processor.processAnnotation(_fieldNature, _annotation,
                OtherwiseAnnotatedClass.class.getDeclaredMethod("getDate"));
        assertFalse(result);
    }

    @Test
    public void annotationValuesAreProcessedCorrectly() throws Exception {
        ClassInfo classInfo = ClassInfoBuilder
                .buildClassInfo(TemporalAnnotatedClass.class);
        assertNotNull(classInfo);
        FieldInfo fieldInfo = classInfo.getFieldInfoByName("date");
        assertTrue(fieldInfo.hasNature(JPAFieldNature.class.getName()));
        JPAFieldNature jpaFieldNature = new JPAFieldNature(fieldInfo);
        assertEquals(TIMESTAMP, jpaFieldNature.getTemporalType());
    }

    // Test classes

    @Ignore
    @Entity
    private class TemporalAnnotatedClass {
        private Date _date;

        @Temporal(TIMESTAMP)
        public Date getDate() {
            return _date;
        }

        public void setDate(final Date date) {
            _date = date;
        }
    }

    @Ignore
    private class NonAnnotatedClass {
        private Date _date;

        public Date getDate() {
            return _date;
        }

        public void setDate(final Date date) {
            _date = date;
        }
    }

    @Ignore
    private class OtherwiseAnnotatedClass {
        private Date _date;

        @Column
        public Date getDate() {
            return _date;
        }

        public void setDate(final Date date) {
            _date = date;
        }
    }
}
