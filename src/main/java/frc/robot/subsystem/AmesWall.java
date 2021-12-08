package frc.robot.subsystem;

import frc.robot.biblioteca.*;

public class AmesWall extends Wall {

    @Override
    public void moveUp() {
        System.out.println("The wall is moving up.");
    }

    @Override
    public void moveDown() {
        System.out.println("The wall is moving down.");
    }

    @Override
    public void moveLeft() {
        System.out.println("The wall is moving left.");
    }

    @Override
    public void moveRight() {
        System.out.println("The wall is moving right.");
    }

    @Override
    public void getPosition() {
        System.out.println("Getting wall's position.");
    }


}