package builder.udemy;

class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public SELF withName(String name) {
        person.setName(name);
        return self();
    }

    public Person buildPerson() {
        return person;
    }

    public SELF self(){
        return (SELF) this;
    }
}
