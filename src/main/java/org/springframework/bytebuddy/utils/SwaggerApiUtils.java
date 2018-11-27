/*
 * Copyright (c) 2018, vindell (https://github.com/vindell).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.springframework.bytebuddy.utils;

import java.lang.annotation.Annotation;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.harmony.lang.annotation.AnnotationMember;
import org.springframework.util.StringUtils;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

public class SwaggerApiUtils {

	/**
	 * 构造 @Api 注解
	 * @param name 			: Implicitly sets a tag for the operations, legacy support (read description).
	 * @param tags 			: A list of tags for API documentation control.
	 * @param produces 		: Corresponds to the `produces` field of the operations under this resource.
	 * @param consumes 		: Corresponds to the `consumes` field of the operations under this resource.For example, "application/json, application/xml" would suggest the operations accept JSON and XML input.
	 * @param protocols		: Sets specific protocols (schemes) for the operations under this resource. Possible values: http, https, ws, wss.
	 * @param authorizations: Corresponds to the `security` field of the Operation Object.   
	 * @see {@link @Api}
	 * @return
	 */
	public static Annotation annotApi(String name, String[] tags, String produces,
			String consumes, String protocols, String[] authorizations) {
		AnnotationMember[] members = new AnnotationMember[] {
			new AnnotationMember("value", StringUtils.hasText(name) ? name : ""),
			new AnnotationMember("tags", ArrayUtils.isEmpty(tags) ? new String[] { "" } : tags),
			new AnnotationMember("produces", StringUtils.hasText(produces) ? produces : "" ),
			new AnnotationMember("consumes", StringUtils.hasText(consumes) ? consumes : ""),
			new AnnotationMember("protocols", StringUtils.hasText(protocols) ? protocols : "")
		};
		return AnnotationUtils.create(Api.class, members);
	}
	
	/**
	 * 构造 @Api 注解
	 * @param name : Implicitly sets a tag for the operations, legacy support (read description).
	 * @param tags : A list of tags for API documentation control.
	 * @return
	 */
	public static Annotation annotApi(String name, String... tags) {
		AnnotationMember[] members = new AnnotationMember[] {
			new AnnotationMember("value", StringUtils.hasText(name) ? name : ""),
			new AnnotationMember("tags", ArrayUtils.isEmpty(tags) ? new String[] { "" } : tags)
		};
		return AnnotationUtils.create(Api.class, members);
	} 
	
	/**
	 * 构造 @ApiIgnore 注解
	 */
	public static Annotation annotApiIgnore(String desc) {
		AnnotationMember[] members = new AnnotationMember[] {
			new AnnotationMember("value", StringUtils.hasText(desc) ? desc : "")
		};
		return AnnotationUtils.create(ApiIgnore.class, members);
	}
	
}