package frc.robot.subsystem;

import frc.robot.biblioteca.*;

public abstract class Wall {
    private double motorSpeed = 0.0;
    private MotorController motorController;

    public Wall () {
        this.motorSpeed = motorSpeed;
        this.motorController = motorController;
    }

    abstract void moveUp();
    abstract void moveDown();
    abstract void moveLeft();
    abstract void moveRight();
    abstract void getPosition();
}