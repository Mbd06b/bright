package com.worscipe.bright.services.gateway;
//
//@Configuration
//public class CorsConfig {

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:4200")
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
//                .allowCredentials(true);
//    }
    
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowCredentials(true)
//                .allowedOrigins("*")
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                .exposedHeaders(HttpHeaders.SET_COOKIE);
//    }
//
//    @Bean
//    public CorsWebFilter corsWebFilter() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addExposedHeader(HttpHeaders.SET_COOKIE);
//        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsWebFilter(corsConfigurationSource);
//    }
//	
//	
//	  private static final String ALLOWED_HEADERS = "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN,token,username,client";
//	    private static final String ALLOWED_METHODS = "*";
//	    private static final String ALLOWED_ORIGIN = "*";
//	    private static final String ALLOWED_EXPOSE = "*";
//	    private static final String MAX_AGE = "3600";

//	    @Bean
//	    public WebFilter corsFilter() {
//	        return (ServerWebExchange ctx, WebFilterChain chain) -> {
//	            ServerHttpRequest request = ctx.getRequest();
//	            if (CorsUtils.isCorsRequest(request)) {
//	                ServerHttpResponse response = ctx.getResponse();
//	                HttpHeaders headers = response.getHeaders();
//	                headers.set("Access-Control-Allow-Origin", ALLOWED_ORIGIN);
//	                headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS);
//	                headers.add("Access-Control-Max-Age", MAX_AGE);
//	                headers.add("Access-Control-Allow-Headers", ALLOWED_HEADERS);
//	                headers.add("Access-Control-Expose-Headers", ALLOWED_EXPOSE);
//	                headers.add("Access-Control-Allow-Credentials", "true");
//	                if (request.getMethod() == HttpMethod.OPTIONS) {
//	                    response.setStatusCode(HttpStatus.OK);
//	                    return Mono.empty();
//	                }
//	            }
//	            return chain.filter(ctx);
//	        };
//	    }

//	  @Bean
//	    public CorsFilter corsFilter() {
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        CorsConfiguration config = new CorsConfiguration();
//	        config.setAllowCredentials(true);
//	        config.addAllowedOrigin("*");
//	        config.addAllowedHeader("*");
//	        config.addAllowedMethod("OPTIONS");
//	        config.addAllowedMethod("GET");
//	        config.addAllowedMethod("POST");
//	        config.addAllowedMethod("PUT");
//	        config.addAllowedMethod("DELETE");
//	        source.registerCorsConfiguration("/**", config);
//	        return new CorsFilter(source);
//	    }
//	
//}