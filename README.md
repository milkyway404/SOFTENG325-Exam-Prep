# Exam Prep
This is a list of libraries that could help in the exam :D good luck!

## Jackson
The jackson package has some helpers to generate json based on Jackson 
annotations. You can put the code supplied in the jackson.domain package,
whatever data needs to be added can be added to those domains in Main. 

Steps:
1. Add classes to domain package as specified by "client"
2. Create data to serialize in Main.
3. You could add annotations to the domain packages first, or
run it and see what happens. Common annotations to use:

- @JsonGetter ("customPropertyName"): Customize property names. Use on getter.
- @JsonSetter ("customPropertyName"): Customize property names. Use on setter.
- @JsonIgnore: Ignore this property. Can use on field or getter or setter, 
does not make a difference. Recommend on field personally because it's clear :)
- @JsonSerialize (using = CustomSerializer.class): Implementation of StdSerializer to appropriately
handle properties that aren't JavaBeans. An example is [LocalDateSerializer](src/jackson/util/LocalDateSerializer.java).
- @JsonDeserialize (using = CustomDeserializer.class): Implementation of StdDeserializer to appropriately
handle properties that aren't JavaBeans. An example is [LocalDateDeserializer](src/jackson/util/LocalDateDeserializer.java).
- @JsonDeserialize (keyUsing = CustomKeyDeserializer.class): An example of using this for a map key is [CourseDeserializer](src/jackson/util/CourseDeserializer.java). For maps, need to 
override toString() of the key class too.
- @JsonIdentityInfo (generator = ObjectIdGenerators.PropertyGenerator.class,
property = "uniqueProperty") : Specify a unique property of the object. The object is only
completely marshalled the first time, later times only this unique property will be written out. Example
in [Course](src/jackson/domain/Course.java).
- @JsonTypeInfo (use = JsonTypeInfo.Id.CLASS, property = "childType"): Supply Java class names to ensure type information is marshalled. Used 
when we marshall the parent class in polymorphism to find the child class the object belongs to. The property is what the
type name will be stored as in the JSON. Gives full name, e.g. jackson.domain.Course.
- @JsonTypeInfo (use = JsonTypeInfo.Id.NAME, property = "childType") and
@JsonSubTypes (value = childClass.class, name = "childName"): Used in conjunction. We
can manually specify the child names that are used in this case, so we can marshall Course instead of
jackson.domain.Course. Need to do this for every new child class.