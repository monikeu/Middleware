// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/currency.proto

package middleware.grpc.gen;

public interface PriceOrBuilder extends
    // @@protoc_insertion_point(interface_extends:routeguide.Price)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.routeguide.Currency currency = 1;</code>
   */
  boolean hasCurrency();
  /**
   * <code>.routeguide.Currency currency = 1;</code>
   */
  middleware.grpc.gen.Currency getCurrency();
  /**
   * <code>.routeguide.Currency currency = 1;</code>
   */
  middleware.grpc.gen.CurrencyOrBuilder getCurrencyOrBuilder();

  /**
   * <code>float value = 2;</code>
   */
  float getValue();
}