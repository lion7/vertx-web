package io.vertx.ext.web.validation.dsl;

import io.vertx.ext.web.validation.ValueParser;
import io.vertx.ext.web.validation.impl.SplitterCharArrayItemByItemParser;

import java.util.List;

@FunctionalInterface
public interface ArrayItemByItemParserFactory {

  ValueParser<String> newArrayParser(List<ValueParser<String>> itemsParser, ValueParser<String> additionalItemsParser);

  static ArrayItemByItemParserFactory commaSeparatedArrayParser() {
    return (itemsParser, additionalItemsParser) -> new SplitterCharArrayItemByItemParser(itemsParser, additionalItemsParser, ",");
  }

}