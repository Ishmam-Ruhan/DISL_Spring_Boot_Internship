# Learnings:
  **RequestParam:**

    - Multiple params can be added just using And->'&' sign
    - Inside Controller, we have to use @RequestParam annotation.
    - We can pass the parameter(required=true/false), it indicates that we always need this parameter or not.
    - Url exm:
      - http://host:port/necessaryPathVariables?param1=valueOfParam1&param2=valueOfParam2
  
  **Content Negotiation:**

    - First, Add "jackson-dataformat-xml" dependency at pom.xml
    - Implement "WebMvcConfigurer" interface and override content negotiation method
    - Add the following configs to configurer instance.
      - .favorParameter(true)                            // Setup param
      - .parameterName("mediaType")                      // Which param we want to add
      - .ignoreAcceptHeader(true)                        // We are not going to use header
      - .useRegisteredExtensionsOnly(false)              // We not only use registered extension but also our custom extension
      - .defaultContentType(MediaType.APPLICATION_JSON)  // Default response will Json
      - .mediaType("xml", MediaType.APPLICATION_XML)     // Media type XML is available
      - .mediaType("json", MediaType.APPLICATION_JSON);  // Media type JSON is available

    - To negotiate with content(Which type of content we need), just pass as request param that "?mediaType=xml" then
      then, it will return xml response. Instead we can use json as well

  **Rest Template:**
    
    - Create a config file, and Create a 'RestTemplate' bean.
    
    ###Get Method:

    - If we want to get list of objects: we have to use 'getForEntityMethod'
        Ex:-> ResponseEntity<OurClass[]> response = restTemplate.getForEntity(JsonPlaceHolder.todoAPI, OurClass[].class);
    - Then, we can convert is as list using Arrays.asList(response.getBody()).
    - We can also get response status code and headers as well from the 'response' object.

    #### Post Method:

    - Have to use restTemplate method: PostForEntity

        Ex: ResponseEntity<ToDo> response = restTemplate.postForEntity(JsonPlaceHolder.todoAPI,toDo,ToDo.class)
                       (Return Object)                       (Url, ourObjectThatWillBePost, Return Object Class)

    #### Put Method:

   **How to CreatedAt and UpdatedAt Automatically**

        1. Create a config file, and add '@EnableJpaAuditig'.

        ###### Above Class:   

        2. We have to add '@EntityListeners' which takes "AuditingEntityListener.class" as parameter. #Class Level

        3. We have to add '@JsonIgnoreProperties(values={"createdAt"."updatedAt"}, allowGetter = true)' #Class Level

                -> Because, our Entity listener will take responsibility to manage these two property.

                -> We only need getter to get those value.


        ##### Above Variable:

        ~ Create at:

                - @NotNull
                - @CreatedDate
                - @Column(nullable = false, updatable = false)
                - @Temporal(TemporalType.TimeStamp)         // Working with Date property in Jpa, we need to specify this. So that, It'll create table-column with equivalent data type.

        ~ Update at:

                - @NotNull
                - @lastModifiedDate
                - @Column(nullable = false)
                - @Temporal(TemporalType.TimeStamp)

  **Working Any Date Property**
  
    -> Above any 'Date' type property, we can add, "@JsonFormat" annotation, to formatted it as string
    -> Example:    
            
            @JsonFormat(shape = JsonFormat.Shape.String, pattern = "dd/MM/yyyy")
            private Date birthDate;