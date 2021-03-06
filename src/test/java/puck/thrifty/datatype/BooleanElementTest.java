package puck.thrifty.datatype;

import org.junit.Assert;
import org.junit.Test;

import puck.thrifty.MergerException;
import puck.thrifty.datatype.BooleanElement;
import puck.thrifty.datatype.DoubleElement;
import puck.thrifty.datatype.Element;
import puck.thrifty.datatype.IntegerElement;
import puck.thrifty.datatype.ListElement;
import puck.thrifty.datatype.LongElement;
import puck.thrifty.datatype.ObjectElement;
import puck.thrifty.datatype.StringElement;
import puck.thrifty.datatype.UnknownElement;

/**
 * <p>
 * Unit tests for the {@link puck.thrifty.datatype.BooleanElement} class.
 * </p>
 */
public class BooleanElementTest {

   /**
    * <p>
    * Tests the properties inherent to a BooleanElement. All BooleanElement
    * instances will answer the same way.
    * </p>
    */
   @Test
   public void confirmElementBasics() {
      
      BooleanElement elem = new BooleanElement("test");
      Assert.assertEquals("1 - datatypeName", "bool", elem.getDatatypeName());
      Assert.assertFalse("3 - isObject", elem.isObject());
      Assert.assertFalse("4 - isUnknown", elem.isUnknown());
   }

   /**
    * <p>
    * Tests that the name is properly set when instantiated.
    * </p>
    */
   @Test
   public void confirmName() {
      Assert.assertEquals("test", new BooleanElement("test").getName());
   }

   /**
    * <p>
    * Tests the get and set of the order.
    * </p>
    */
   @Test
   public void confirmGetSetOrder() {
      BooleanElement elem = new BooleanElement("test");
      elem.setOrder(20);
      Assert.assertEquals(20, elem.getOrder());
   }
   
   @Test
   public void mergeWithNull() {
      BooleanElement elem = new BooleanElement("test");
      Element mergeElem = elem.merge(null);
      Assert.assertSame(elem, mergeElem);
   }
   
   @Test
   public void mergeWithSameBoolean() {
      BooleanElement elem = new BooleanElement("test");
      Element mergeElem = elem.merge(elem);
      Assert.assertSame(elem, mergeElem);
   }
   
   @Test
   public void mergeWithDifferentBoolean() {
      BooleanElement elem = new BooleanElement("test");
      Element mergeElem = elem.merge(new BooleanElement("test"));
      Assert.assertSame(elem, mergeElem);
   }
   
   @Test
   public void mergeWithUnknown() {
      BooleanElement elem = new BooleanElement("test");
      Element mergeElem = elem.merge(new UnknownElement("test"));
      Assert.assertSame(elem, mergeElem);
   }
   
   @Test
   public void mergeWithDouble() {
      try {
         new BooleanElement("test").merge(new DoubleElement("test"));
      } catch (MergerException e) {
      }
   }
   
   @Test
   public void mergeWithInteger() {
      try {
         new BooleanElement("test").merge(new IntegerElement("test"));
      } catch (MergerException e) {
      }
   }
   
   @Test
   public void mergeWithLong() {
      try {
         new BooleanElement("test").merge(new LongElement("test"));
      } catch (MergerException e) {
      }
   }
   
   @Test
   public void mergeWithString() {
      try {
         new BooleanElement("test").merge(new StringElement("test"));
      } catch (MergerException e) {
      }
   }
   
   @Test
   public void mergeWithList() {
      try {
         new BooleanElement("test").merge(new ListElement(new BooleanElement("test")));
         Assert.fail();
      } catch (MergerException e) {
      }
   }
   
   @Test
   public void mergeWithObject() {
      try {
         new BooleanElement("test").merge(new ObjectElement("test"));
         Assert.fail();
      } catch (MergerException e) {
      }
   }
   
   @Test
   public void equalsItself() {
      BooleanElement elem = new BooleanElement("test");
      Assert.assertTrue(elem.equals(elem));
   }
   
   @Test
   public void equalsSameObjectTypeDifferentName() {
      Assert.assertFalse(new BooleanElement("test").equals(new BooleanElement("test2")));
   }
   
   @Test
   public void equalsWithBoolean() {
      Assert.assertTrue(new BooleanElement("test").equals(new BooleanElement("test")));
   }
   
   @Test
   public void equalsWithDouble() {
      Assert.assertFalse(new BooleanElement("test").equals(new DoubleElement("test")));
   }
   
   @Test
   public void equalsWithInteger() {
      Assert.assertFalse(new BooleanElement("test").equals(new IntegerElement("test")));
   }
   
   @Test
   public void equalsWithLong() {
      Assert.assertFalse(new BooleanElement("test").equals(new LongElement("test")));
   }
   
   @Test
   public void equalsWithObject() {
      Assert.assertFalse(new BooleanElement("test").equals(new ObjectElement("test")));
   }
   
   @Test
   public void equalsWithString() {
      Assert.assertFalse(new BooleanElement("test").equals(new StringElement("test")));
   }
   
   @Test
   public void equalsWithListOfBoolean() {
      Assert.assertFalse(new BooleanElement("test").equals(new ListElement(new BooleanElement("test"))));
   }
   
   @Test
   public void equalsWithListOfDouble() {
      Assert.assertFalse(new BooleanElement("test").equals(new ListElement(new DoubleElement("test"))));
   }
   
   @Test
   public void equalsWithListOfInteger() {
      Assert.assertFalse(new BooleanElement("test").equals(new ListElement(new IntegerElement("test"))));
   }
   
   @Test
   public void equalsWithListOfLong() {
      Assert.assertFalse(new BooleanElement("test").equals(new ListElement(new LongElement("test"))));
   }
   
   @Test
   public void equalsWithListOfObject() {
      Assert.assertFalse(new BooleanElement("test").equals(new ListElement(new ObjectElement("test"))));
   }
   
   @Test
   public void equalsWithListOfString() {
      Assert.assertFalse(new BooleanElement("test").equals(new ListElement(new StringElement("test"))));
   }
}
