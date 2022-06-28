**# Learnings:**

 1. How Spring Security Works Internally (Notes & Cases)
 2. Basic Authentication
 3. Digest Authentication
 4. Enabling HTTPS(Http+SSL/TLS) for our application

 5. Know How to Map Non-Embeddable(String,Integer,Long, etc)

    `@ElementCollection          //  	It marks as map to a collection. All the records of the collection are stored in a seperate table.
    @CollectionTable(name="table_name", joinColumns=@JoinColumn(name="current_class_id"))       // 	Specify the name of the table in which all the collection information is stored
     @Column(name="phone_number")  // Mapping Column Name`
    ` private Set<String> phones;`

**# Most Important Files:**
 1. Application.yml
 2. BasicAuthFilter
 3. TomcatConfig