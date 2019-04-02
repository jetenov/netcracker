package ru.skillbench.tasks.basics.entity;

public class EmployeeImpl implements Employee {



    private String firstName;
    private String lastName;
    private int salary = 1000;
    private Employee manager;


    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public void increaseSalary(int value) {
        salary = getSalary() + value;

    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String getManagerName() {
        if (this.manager == null)
            return "No manager";
        return manager.getFullName();
    }

    /**
     * Возвращает Менеджера верхнего уровня, т.е. вершину иерархии сотрудников,
     *   в которую входит данный сотрудник.
     * Если над данным сотрудником нет ни одного менеджера, возвращает данного сотрудника.
     * Замечание: поскольку менеджер, установленный методом {@link #setManager(Employee)},
     *   может быть экзепляром другого класса, при поиске топ-менеджера нельзя обращаться
     *   к полям класса EmployeeImpl. Более того, поскольку в интерфейсе Employee не объявлено
     *   метода getManager(), поиск топ-менеджера невозможно организовать в виде цикла.
     *   Вместо этого нужно использовать рекурсию (и это "более объектно-ориентированно").
     */

    @Override
    public Employee getTopManager() {
        if (this.manager == null)
            return this;
        else
            return manager.getTopManager();
    }
}
