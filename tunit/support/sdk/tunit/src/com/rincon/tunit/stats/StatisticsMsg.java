/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'StatisticsMsg'
 * message type.
 */

package com.rincon.tunit.stats;

/*
 * Copyright (c) 2005-2006 Rincon Research Corporation
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the
 *   distribution.
 * - Neither the name of the Rincon Research Corporation nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE
 * RINCON RESEARCH OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE
 */

public class StatisticsMsg extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 28;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 254;

    /** Create a new StatisticsMsg of size 28. */
    public StatisticsMsg() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new StatisticsMsg of the given data_length. */
    public StatisticsMsg(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new StatisticsMsg with the given data_length
     * and base offset.
     */
    public StatisticsMsg(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new StatisticsMsg using the given byte array
     * as backing store.
     */
    public StatisticsMsg(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new StatisticsMsg using the given byte array
     * as backing store, with the given base offset.
     */
    public StatisticsMsg(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new StatisticsMsg using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public StatisticsMsg(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new StatisticsMsg embedded in the given message
     * at the given base offset.
     */
    public StatisticsMsg(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new StatisticsMsg embedded in the given message
     * at the given base offset and length.
     */
    public StatisticsMsg(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <StatisticsMsg> \n";
      try {
        s += "  [value=0x"+Long.toHexString(get_value())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [statsId=0x"+Long.toHexString(get_statsId())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [unitLength=0x"+Long.toHexString(get_unitLength())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [units=";
        for (int i = 0; i < 22; i++) {
          s += "0x"+Long.toHexString(getElement_units(i) & 0xff)+" ";
        }
        s += "]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: value
    //   Field type: long, unsigned
    //   Offset (bits): 0
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'value' is signed (false).
     */
    public static boolean isSigned_value() {
        return false;
    }

    /**
     * Return whether the field 'value' is an array (false).
     */
    public static boolean isArray_value() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'value'
     */
    public static int offset_value() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'value'
     */
    public static int offsetBits_value() {
        return 0;
    }

    /**
     * Return the value (as a long) of the field 'value'
     */
    public long get_value() {
        return (long)getSIntBEElement(offsetBits_value(), 32);
    }

    /**
     * Set the value of the field 'value'
     */
    public void set_value(long value) {
        setSIntBEElement(offsetBits_value(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 'value'
     */
    public static int size_value() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 'value'
     */
    public static int sizeBits_value() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: statsId
    //   Field type: short, unsigned
    //   Offset (bits): 32
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'statsId' is signed (false).
     */
    public static boolean isSigned_statsId() {
        return false;
    }

    /**
     * Return whether the field 'statsId' is an array (false).
     */
    public static boolean isArray_statsId() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'statsId'
     */
    public static int offset_statsId() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'statsId'
     */
    public static int offsetBits_statsId() {
        return 32;
    }

    /**
     * Return the value (as a short) of the field 'statsId'
     */
    public short get_statsId() {
        return (short)getUIntBEElement(offsetBits_statsId(), 8);
    }

    /**
     * Set the value of the field 'statsId'
     */
    public void set_statsId(short value) {
        setUIntBEElement(offsetBits_statsId(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'statsId'
     */
    public static int size_statsId() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'statsId'
     */
    public static int sizeBits_statsId() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: unitLength
    //   Field type: short, unsigned
    //   Offset (bits): 40
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'unitLength' is signed (false).
     */
    public static boolean isSigned_unitLength() {
        return false;
    }

    /**
     * Return whether the field 'unitLength' is an array (false).
     */
    public static boolean isArray_unitLength() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'unitLength'
     */
    public static int offset_unitLength() {
        return (40 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'unitLength'
     */
    public static int offsetBits_unitLength() {
        return 40;
    }

    /**
     * Return the value (as a short) of the field 'unitLength'
     */
    public short get_unitLength() {
        return (short)getUIntBEElement(offsetBits_unitLength(), 8);
    }

    /**
     * Set the value of the field 'unitLength'
     */
    public void set_unitLength(short value) {
        setUIntBEElement(offsetBits_unitLength(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'unitLength'
     */
    public static int size_unitLength() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'unitLength'
     */
    public static int sizeBits_unitLength() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: units
    //   Field type: short[], unsigned
    //   Offset (bits): 48
    //   Size of each element (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'units' is signed (false).
     */
    public static boolean isSigned_units() {
        return false;
    }

    /**
     * Return whether the field 'units' is an array (true).
     */
    public static boolean isArray_units() {
        return true;
    }

    /**
     * Return the offset (in bytes) of the field 'units'
     */
    public static int offset_units(int index1) {
        int offset = 48;
        if (index1 < 0 || index1 >= 22) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 8;
        return (offset / 8);
    }

    /**
     * Return the offset (in bits) of the field 'units'
     */
    public static int offsetBits_units(int index1) {
        int offset = 48;
        if (index1 < 0 || index1 >= 22) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 8;
        return offset;
    }

    /**
     * Return the entire array 'units' as a short[]
     */
    public short[] get_units() {
        short[] tmp = new short[22];
        for (int index0 = 0; index0 < numElements_units(0); index0++) {
            tmp[index0] = getElement_units(index0);
        }
        return tmp;
    }

    /**
     * Set the contents of the array 'units' from the given short[]
     */
    public void set_units(short[] value) {
        for (int index0 = 0; index0 < value.length; index0++) {
            setElement_units(index0, value[index0]);
        }
    }

    /**
     * Return an element (as a short) of the array 'units'
     */
    public short getElement_units(int index1) {
        return (short)getUIntBEElement(offsetBits_units(index1), 8);
    }

    /**
     * Set an element of the array 'units'
     */
    public void setElement_units(int index1, short value) {
        setUIntBEElement(offsetBits_units(index1), 8, value);
    }

    /**
     * Return the total size, in bytes, of the array 'units'
     */
    public static int totalSize_units() {
        return (176 / 8);
    }

    /**
     * Return the total size, in bits, of the array 'units'
     */
    public static int totalSizeBits_units() {
        return 176;
    }

    /**
     * Return the size, in bytes, of each element of the array 'units'
     */
    public static int elementSize_units() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of each element of the array 'units'
     */
    public static int elementSizeBits_units() {
        return 8;
    }

    /**
     * Return the number of dimensions in the array 'units'
     */
    public static int numDimensions_units() {
        return 1;
    }

    /**
     * Return the number of elements in the array 'units'
     */
    public static int numElements_units() {
        return 22;
    }

    /**
     * Return the number of elements in the array 'units'
     * for the given dimension.
     */
    public static int numElements_units(int dimension) {
      int array_dims[] = { 22,  };
        if (dimension < 0 || dimension >= 1) throw new ArrayIndexOutOfBoundsException();
        if (array_dims[dimension] == 0) throw new IllegalArgumentException("Array dimension "+dimension+" has unknown size");
        return array_dims[dimension];
    }

    /**
     * Fill in the array 'units' with a String
     */
    public void setString_units(String s) { 
         int len = s.length();
         int i;
         for (i = 0; i < len; i++) {
             setElement_units(i, (short)s.charAt(i));
         }
         setElement_units(i, (short)0); //null terminate
    }

    /**
     * Read the array 'units' as a String
     */
    public String getString_units() { 
         char carr[] = new char[Math.min(net.tinyos.message.Message.MAX_CONVERTED_STRING_LENGTH,22)];
         int i;
         for (i = 0; i < carr.length; i++) {
             if ((char)getElement_units(i) == (char)0) break;
             carr[i] = (char)getElement_units(i);
         }
         return new String(carr,0,i);
    }

}
