package com.schlaepfer.health.commons;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.UUID.randomUUID;

public final class Routes {
	
	public static final String PREFIX = "springboot";

	private Routes() {
	}

	public static String id(final Class<?> routeBuilderClass, final String label) {
		checkArgument(!isNull(routeBuilderClass), "Argument 'routeBuilderClass' must not be null or empty.");
		checkArgument(!isNullOrEmpty(label), "Argument 'label' must not be null or empty.");

		// noinspection ConstantConditions
		return format("[%s/%s/%s]", PREFIX, routeBuilderClass.getCanonicalName(), label);
	}

	public static String processId() {
		return randomUUID().toString();
	}

}
