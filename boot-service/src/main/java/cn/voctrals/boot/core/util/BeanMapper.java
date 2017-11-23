/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.voctrals.boot.core.util;

import cn.voctrals.boot.core.converter.*;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

import java.util.List;

/**
 * 简单封装orika, 实现深度转换Bean<->Bean的Mapper.
 */
public class BeanMapper {

	private static MapperFacade mapper = null;

    private static MapperFactory mapperFactory = null;

    private static final BidirectionalConverter[] converters = new BidirectionalConverter[]{
            new BigDecimalEmptyToNullConverter(),
            new ByteDoubleEmptyToNullConverter(),
            new DoubleEmptyToNullConverter(),
            new FloatEmptyToNullConverter(),
            new IntegerEmptyToNullConverter(),
            new LongEmptyToNullConverter(),
            new ShortEmptyToNullConverter(),
            new DateEmptyToNullConverter()
    };

	static {
		mapperFactory = new DefaultMapperFactory.Builder().dumpStateOnException(false).mapNulls(true).build();
		ConverterFactory converterFactory = mapperFactory.getConverterFactory();

        for (BidirectionalConverter converter : converters) {
            converterFactory.registerConverter(converter);
        }

		mapper = mapperFactory.getMapperFacade();
	}


    /**
     * 对象转换
     * @param source 源对象
     * @param destinationClass 目标对象类型
     * @return 转换后对象
     */
	public static <S, D> D map(S source, Class<D> destinationClass) {
		return mapper.map(source, destinationClass);
	}

    /**
     * 对象List转换
     * @param sourceList 源对象
     * @param destinationClass 目标对象类型
     * @return 转换后对象List
     */
	public static <S, D> List<D> mapList(Iterable<S> sourceList, Class<D> destinationClass) {
		return mapper.mapAsList(sourceList, destinationClass);
	}

    public static <S, D> D mapByExclude(S source, Class<S> sourceClass, Class<D> destinationClass, String[] fieldList) {
        MapperFactory defaultMapperFactory = new DefaultMapperFactory.Builder().dumpStateOnException(false).mapNulls(true).build();

        ConverterFactory converterFactory = defaultMapperFactory.getConverterFactory();
        for (BidirectionalConverter converter : converters) {
            converterFactory.registerConverter(converter);
        }

        ClassMapBuilder builder = defaultMapperFactory.classMap(sourceClass, destinationClass);
        if (fieldList != null) {
            for (String field : fieldList) {
                builder.exclude(field);
            }
        }
        builder.byDefault().register();

        return defaultMapperFactory.getMapperFacade().map(source, destinationClass);
    }
}