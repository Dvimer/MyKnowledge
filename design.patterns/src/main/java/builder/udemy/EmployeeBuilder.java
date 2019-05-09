package builder.udemy;


class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{
    public EmployeeBuilder worksAt(String position){
        person.setPosition(position);
        return self();
    }

    @Override
    public EmployeeBuilder self() {
        return this;
    }
}
