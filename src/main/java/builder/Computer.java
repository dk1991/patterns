package builder;

/*
    builder для конструирования разных сложных объектов из одного и того же набора данных,
    так чтобы процесс создания объекта не зависел от того из каких частей конструированный объект состоит.
 */

public class Computer {
    private int ram;
    private HDD hdd;
    private String processor;

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ram=" + ram +
                ", hdd=" + hdd +
                ", processor='" + processor + '\'' +
                '}';
    }
}

interface HDD {
    String getRam();
}

class SATAThree implements HDD {
    @Override
    public String getRam() {
        return "SATA_3";
    }
}

class SATATwo implements HDD {
    @Override
    public String getRam() {
        return "SATA_2";
    }
}

abstract class ComputerBuilder {
    Computer computer;

    void createComputer() {
        computer = new Computer();
    }

    Computer getComputer() {
        return computer;
    }

    abstract void buildRam();
    abstract void buildProcessor();
    abstract void buildHDD();
}

class StrongComputerBuilder extends ComputerBuilder {

    @Override
    void buildRam() {
        computer.setHdd(new SATAThree());
    }

    @Override
    void buildProcessor() {
        computer.setProcessor("Intel i7");
    }

    @Override
    void buildHDD() {
        computer.setRam(32_000);
    }
}

class WeakComputerBuilder extends ComputerBuilder {

    @Override
    void buildRam() {
        computer.setHdd(new SATATwo());
    }

    @Override
    void buildProcessor() {
        computer.setProcessor("Intel i3");
    }

    @Override
    void buildHDD() {
        computer.setRam(2_000);
    }
}

class Headman {
    private ComputerBuilder builder;

    public void setBuilder(ComputerBuilder builder) {
        this.builder = builder;
    }

    Computer buildComputer() {
        builder.createComputer();
        builder.buildProcessor();
        builder.buildRam();
        builder.buildHDD();

        return builder.getComputer();
    }
}

class Client {
    public static void main(String[] args) {
        Headman headman = new Headman();
        headman.setBuilder(new WeakComputerBuilder());
        Computer myPC = headman.buildComputer();
        System.out.println(myPC);
    }
}