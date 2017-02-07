/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.vrg.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.Option;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"all"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-02-07")
public class LinkUpdateMessageT implements org.apache.thrift.TBase<LinkUpdateMessageT, LinkUpdateMessageT._Fields>, java.io.Serializable, Cloneable, Comparable<LinkUpdateMessageT> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LinkUpdateMessageT");

  private static final org.apache.thrift.protocol.TField SRC_FIELD_DESC = new org.apache.thrift.protocol.TField("src", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField DST_FIELD_DESC = new org.apache.thrift.protocol.TField("dst", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField OP_FIELD_DESC = new org.apache.thrift.protocol.TField("op", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField CONFIG_FIELD_DESC = new org.apache.thrift.protocol.TField("config", org.apache.thrift.protocol.TType.I64, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new LinkUpdateMessageTStandardSchemeFactory());
    schemes.put(TupleScheme.class, new LinkUpdateMessageTTupleSchemeFactory());
  }

  public String src; // required
  public String dst; // required
  /**
   * 
   * @see Status
   */
  public Status op; // required
  public long config; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SRC((short)1, "src"),
    DST((short)2, "dst"),
    /**
     * 
     * @see Status
     */
    OP((short)3, "op"),
    CONFIG((short)4, "config");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SRC
          return SRC;
        case 2: // DST
          return DST;
        case 3: // OP
          return OP;
        case 4: // CONFIG
          return CONFIG;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __CONFIG_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SRC, new org.apache.thrift.meta_data.FieldMetaData("src", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DST, new org.apache.thrift.meta_data.FieldMetaData("dst", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.OP, new org.apache.thrift.meta_data.FieldMetaData("op", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, Status.class)));
    tmpMap.put(_Fields.CONFIG, new org.apache.thrift.meta_data.FieldMetaData("config", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LinkUpdateMessageT.class, metaDataMap);
  }

  public LinkUpdateMessageT() {
  }

  public LinkUpdateMessageT(
    String src,
    String dst,
    Status op,
    long config)
  {
    this();
    this.src = src;
    this.dst = dst;
    this.op = op;
    this.config = config;
    setConfigIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LinkUpdateMessageT(LinkUpdateMessageT other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetSrc()) {
      this.src = other.src;
    }
    if (other.isSetDst()) {
      this.dst = other.dst;
    }
    if (other.isSetOp()) {
      this.op = other.op;
    }
    this.config = other.config;
  }

  public LinkUpdateMessageT deepCopy() {
    return new LinkUpdateMessageT(this);
  }

  @Override
  public void clear() {
    this.src = null;
    this.dst = null;
    this.op = null;
    setConfigIsSet(false);
    this.config = 0;
  }

  public String getSrc() {
    return this.src;
  }

  public LinkUpdateMessageT setSrc(String src) {
    this.src = src;
    return this;
  }

  public void unsetSrc() {
    this.src = null;
  }

  /** Returns true if field src is set (has been assigned a value) and false otherwise */
  public boolean isSetSrc() {
    return this.src != null;
  }

  public void setSrcIsSet(boolean value) {
    if (!value) {
      this.src = null;
    }
  }

  public String getDst() {
    return this.dst;
  }

  public LinkUpdateMessageT setDst(String dst) {
    this.dst = dst;
    return this;
  }

  public void unsetDst() {
    this.dst = null;
  }

  /** Returns true if field dst is set (has been assigned a value) and false otherwise */
  public boolean isSetDst() {
    return this.dst != null;
  }

  public void setDstIsSet(boolean value) {
    if (!value) {
      this.dst = null;
    }
  }

  /**
   * 
   * @see Status
   */
  public Status getOp() {
    return this.op;
  }

  /**
   * 
   * @see Status
   */
  public LinkUpdateMessageT setOp(Status op) {
    this.op = op;
    return this;
  }

  public void unsetOp() {
    this.op = null;
  }

  /** Returns true if field op is set (has been assigned a value) and false otherwise */
  public boolean isSetOp() {
    return this.op != null;
  }

  public void setOpIsSet(boolean value) {
    if (!value) {
      this.op = null;
    }
  }

  public long getConfig() {
    return this.config;
  }

  public LinkUpdateMessageT setConfig(long config) {
    this.config = config;
    setConfigIsSet(true);
    return this;
  }

  public void unsetConfig() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CONFIG_ISSET_ID);
  }

  /** Returns true if field config is set (has been assigned a value) and false otherwise */
  public boolean isSetConfig() {
    return EncodingUtils.testBit(__isset_bitfield, __CONFIG_ISSET_ID);
  }

  public void setConfigIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CONFIG_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SRC:
      if (value == null) {
        unsetSrc();
      } else {
        setSrc((String)value);
      }
      break;

    case DST:
      if (value == null) {
        unsetDst();
      } else {
        setDst((String)value);
      }
      break;

    case OP:
      if (value == null) {
        unsetOp();
      } else {
        setOp((Status)value);
      }
      break;

    case CONFIG:
      if (value == null) {
        unsetConfig();
      } else {
        setConfig((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SRC:
      return getSrc();

    case DST:
      return getDst();

    case OP:
      return getOp();

    case CONFIG:
      return getConfig();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SRC:
      return isSetSrc();
    case DST:
      return isSetDst();
    case OP:
      return isSetOp();
    case CONFIG:
      return isSetConfig();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof LinkUpdateMessageT)
      return this.equals((LinkUpdateMessageT)that);
    return false;
  }

  public boolean equals(LinkUpdateMessageT that) {
    if (that == null)
      return false;

    boolean this_present_src = true && this.isSetSrc();
    boolean that_present_src = true && that.isSetSrc();
    if (this_present_src || that_present_src) {
      if (!(this_present_src && that_present_src))
        return false;
      if (!this.src.equals(that.src))
        return false;
    }

    boolean this_present_dst = true && this.isSetDst();
    boolean that_present_dst = true && that.isSetDst();
    if (this_present_dst || that_present_dst) {
      if (!(this_present_dst && that_present_dst))
        return false;
      if (!this.dst.equals(that.dst))
        return false;
    }

    boolean this_present_op = true && this.isSetOp();
    boolean that_present_op = true && that.isSetOp();
    if (this_present_op || that_present_op) {
      if (!(this_present_op && that_present_op))
        return false;
      if (!this.op.equals(that.op))
        return false;
    }

    boolean this_present_config = true;
    boolean that_present_config = true;
    if (this_present_config || that_present_config) {
      if (!(this_present_config && that_present_config))
        return false;
      if (this.config != that.config)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_src = true && (isSetSrc());
    list.add(present_src);
    if (present_src)
      list.add(src);

    boolean present_dst = true && (isSetDst());
    list.add(present_dst);
    if (present_dst)
      list.add(dst);

    boolean present_op = true && (isSetOp());
    list.add(present_op);
    if (present_op)
      list.add(op.getValue());

    boolean present_config = true;
    list.add(present_config);
    if (present_config)
      list.add(config);

    return list.hashCode();
  }

  @Override
  public int compareTo(LinkUpdateMessageT other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSrc()).compareTo(other.isSetSrc());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSrc()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.src, other.src);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDst()).compareTo(other.isSetDst());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDst()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dst, other.dst);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOp()).compareTo(other.isSetOp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.op, other.op);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetConfig()).compareTo(other.isSetConfig());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetConfig()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.config, other.config);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("LinkUpdateMessageT(");
    boolean first = true;

    sb.append("src:");
    if (this.src == null) {
      sb.append("null");
    } else {
      sb.append(this.src);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("dst:");
    if (this.dst == null) {
      sb.append("null");
    } else {
      sb.append(this.dst);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("op:");
    if (this.op == null) {
      sb.append("null");
    } else {
      sb.append(this.op);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("config:");
    sb.append(this.config);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LinkUpdateMessageTStandardSchemeFactory implements SchemeFactory {
    public LinkUpdateMessageTStandardScheme getScheme() {
      return new LinkUpdateMessageTStandardScheme();
    }
  }

  private static class LinkUpdateMessageTStandardScheme extends StandardScheme<LinkUpdateMessageT> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, LinkUpdateMessageT struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SRC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.src = iprot.readString();
              struct.setSrcIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dst = iprot.readString();
              struct.setDstIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // OP
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.op = com.vrg.thrift.Status.findByValue(iprot.readI32());
              struct.setOpIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CONFIG
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.config = iprot.readI64();
              struct.setConfigIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, LinkUpdateMessageT struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.src != null) {
        oprot.writeFieldBegin(SRC_FIELD_DESC);
        oprot.writeString(struct.src);
        oprot.writeFieldEnd();
      }
      if (struct.dst != null) {
        oprot.writeFieldBegin(DST_FIELD_DESC);
        oprot.writeString(struct.dst);
        oprot.writeFieldEnd();
      }
      if (struct.op != null) {
        oprot.writeFieldBegin(OP_FIELD_DESC);
        oprot.writeI32(struct.op.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(CONFIG_FIELD_DESC);
      oprot.writeI64(struct.config);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LinkUpdateMessageTTupleSchemeFactory implements SchemeFactory {
    public LinkUpdateMessageTTupleScheme getScheme() {
      return new LinkUpdateMessageTTupleScheme();
    }
  }

  private static class LinkUpdateMessageTTupleScheme extends TupleScheme<LinkUpdateMessageT> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, LinkUpdateMessageT struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSrc()) {
        optionals.set(0);
      }
      if (struct.isSetDst()) {
        optionals.set(1);
      }
      if (struct.isSetOp()) {
        optionals.set(2);
      }
      if (struct.isSetConfig()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetSrc()) {
        oprot.writeString(struct.src);
      }
      if (struct.isSetDst()) {
        oprot.writeString(struct.dst);
      }
      if (struct.isSetOp()) {
        oprot.writeI32(struct.op.getValue());
      }
      if (struct.isSetConfig()) {
        oprot.writeI64(struct.config);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, LinkUpdateMessageT struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.src = iprot.readString();
        struct.setSrcIsSet(true);
      }
      if (incoming.get(1)) {
        struct.dst = iprot.readString();
        struct.setDstIsSet(true);
      }
      if (incoming.get(2)) {
        struct.op = com.vrg.thrift.Status.findByValue(iprot.readI32());
        struct.setOpIsSet(true);
      }
      if (incoming.get(3)) {
        struct.config = iprot.readI64();
        struct.setConfigIsSet(true);
      }
    }
  }

}

