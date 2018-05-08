// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/currency.proto

package middleware.gRPC.gen;

/**
 * Protobuf type {@code routeguide.Price}
 */
public  final class Price extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:routeguide.Price)
        PriceOrBuilder {
  // Use Price.newBuilder() to construct.
  private Price(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Price() {
    value_ = 0F;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private Price(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            Currency.Builder subBuilder = null;
            if (currency_ != null) {
              subBuilder = currency_.toBuilder();
            }
            currency_ = input.readMessage(Currency.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(currency_);
              currency_ = subBuilder.buildPartial();
            }

            break;
          }
          case 21: {

            value_ = input.readFloat();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return CurrencyDataProto.internal_static_routeguide_Price_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return CurrencyDataProto.internal_static_routeguide_Price_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Price.class, Price.Builder.class);
  }

  public static final int CURRENCY_FIELD_NUMBER = 1;
  private Currency currency_;
  /**
   * <code>.routeguide.Currency currency = 1;</code>
   */
  public boolean hasCurrency() {
    return currency_ != null;
  }
  /**
   * <code>.routeguide.Currency currency = 1;</code>
   */
  public Currency getCurrency() {
    return currency_ == null ? Currency.getDefaultInstance() : currency_;
  }
  /**
   * <code>.routeguide.Currency currency = 1;</code>
   */
  public CurrencyOrBuilder getCurrencyOrBuilder() {
    return getCurrency();
  }

  public static final int VALUE_FIELD_NUMBER = 2;
  private float value_;
  /**
   * <code>float value = 2;</code>
   */
  public float getValue() {
    return value_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (currency_ != null) {
      output.writeMessage(1, getCurrency());
    }
    if (value_ != 0F) {
      output.writeFloat(2, value_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (currency_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getCurrency());
    }
    if (value_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, value_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof Price)) {
      return super.equals(obj);
    }
    Price other = (Price) obj;

    boolean result = true;
    result = result && (hasCurrency() == other.hasCurrency());
    if (hasCurrency()) {
      result = result && getCurrency()
          .equals(other.getCurrency());
    }
    result = result && (
        java.lang.Float.floatToIntBits(getValue())
        == java.lang.Float.floatToIntBits(
            other.getValue()));
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasCurrency()) {
      hash = (37 * hash) + CURRENCY_FIELD_NUMBER;
      hash = (53 * hash) + getCurrency().hashCode();
    }
    hash = (37 * hash) + VALUE_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getValue());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Price parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Price parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Price parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Price parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Price parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Price parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static Price parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static Price parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Price parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Price parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Price prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code routeguide.Price}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:routeguide.Price)
      PriceOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CurrencyDataProto.internal_static_routeguide_Price_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CurrencyDataProto.internal_static_routeguide_Price_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Price.class, Price.Builder.class);
    }

    // Construct using Price.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      if (currencyBuilder_ == null) {
        currency_ = null;
      } else {
        currency_ = null;
        currencyBuilder_ = null;
      }
      value_ = 0F;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return CurrencyDataProto.internal_static_routeguide_Price_descriptor;
    }

    public Price getDefaultInstanceForType() {
      return Price.getDefaultInstance();
    }

    public Price build() {
      Price result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public Price buildPartial() {
      Price result = new Price(this);
      if (currencyBuilder_ == null) {
        result.currency_ = currency_;
      } else {
        result.currency_ = currencyBuilder_.build();
      }
      result.value_ = value_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof Price) {
        return mergeFrom((Price)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Price other) {
      if (other == Price.getDefaultInstance()) return this;
      if (other.hasCurrency()) {
        mergeCurrency(other.getCurrency());
      }
      if (other.getValue() != 0F) {
        setValue(other.getValue());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Price parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (Price) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Currency currency_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        Currency, Currency.Builder, CurrencyOrBuilder> currencyBuilder_;
    /**
     * <code>.routeguide.Currency currency = 1;</code>
     */
    public boolean hasCurrency() {
      return currencyBuilder_ != null || currency_ != null;
    }
    /**
     * <code>.routeguide.Currency currency = 1;</code>
     */
    public Currency getCurrency() {
      if (currencyBuilder_ == null) {
        return currency_ == null ? Currency.getDefaultInstance() : currency_;
      } else {
        return currencyBuilder_.getMessage();
      }
    }
    /**
     * <code>.routeguide.Currency currency = 1;</code>
     */
    public Builder setCurrency(Currency value) {
      if (currencyBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        currency_ = value;
        onChanged();
      } else {
        currencyBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.routeguide.Currency currency = 1;</code>
     */
    public Builder setCurrency(
        Currency.Builder builderForValue) {
      if (currencyBuilder_ == null) {
        currency_ = builderForValue.build();
        onChanged();
      } else {
        currencyBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.routeguide.Currency currency = 1;</code>
     */
    public Builder mergeCurrency(Currency value) {
      if (currencyBuilder_ == null) {
        if (currency_ != null) {
          currency_ =
            Currency.newBuilder(currency_).mergeFrom(value).buildPartial();
        } else {
          currency_ = value;
        }
        onChanged();
      } else {
        currencyBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.routeguide.Currency currency = 1;</code>
     */
    public Builder clearCurrency() {
      if (currencyBuilder_ == null) {
        currency_ = null;
        onChanged();
      } else {
        currency_ = null;
        currencyBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.routeguide.Currency currency = 1;</code>
     */
    public Currency.Builder getCurrencyBuilder() {
      
      onChanged();
      return getCurrencyFieldBuilder().getBuilder();
    }
    /**
     * <code>.routeguide.Currency currency = 1;</code>
     */
    public CurrencyOrBuilder getCurrencyOrBuilder() {
      if (currencyBuilder_ != null) {
        return currencyBuilder_.getMessageOrBuilder();
      } else {
        return currency_ == null ?
            Currency.getDefaultInstance() : currency_;
      }
    }
    /**
     * <code>.routeguide.Currency currency = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        Currency, Currency.Builder, CurrencyOrBuilder> 
        getCurrencyFieldBuilder() {
      if (currencyBuilder_ == null) {
        currencyBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            Currency, Currency.Builder, CurrencyOrBuilder>(
                getCurrency(),
                getParentForChildren(),
                isClean());
        currency_ = null;
      }
      return currencyBuilder_;
    }

    private float value_ ;
    /**
     * <code>float value = 2;</code>
     */
    public float getValue() {
      return value_;
    }
    /**
     * <code>float value = 2;</code>
     */
    public Builder setValue(float value) {
      
      value_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float value = 2;</code>
     */
    public Builder clearValue() {
      
      value_ = 0F;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:routeguide.Price)
  }

  // @@protoc_insertion_point(class_scope:routeguide.Price)
  private static final Price DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Price();
  }

  public static Price getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Price>
      PARSER = new com.google.protobuf.AbstractParser<Price>() {
    public Price parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Price(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Price> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Price> getParserForType() {
    return PARSER;
  }

  public Price getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
