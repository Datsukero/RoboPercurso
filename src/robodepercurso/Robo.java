/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robodepercurso;

/**
 *
 * @author ClaudineiJr
 */
class Robo extends RoboDePercurso {

    String[][] mundo;
    String direcao;
    String robot;
    int x;
    int y;

    public Robo(String[][] mundo, String direcao, String robot, int x, int y) {
        this.mundo = mundo;
        this.direcao = direcao;
        this.robot = robot;
        this.x = x;
        this.y = y;
    }

    public String[][] getMundo() {
        return mundo;
    }

    public String getDirecao() {
        return direcao;
    }

    public String getRobot() {
        return robot;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setMundo(String[][] mundo) {
        this.mundo = mundo;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public void setRobot(String robot) {
        this.robot = robot;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Robo{" + ", direcao=" + direcao + ", x=" + x + ", y=" + y + '}';
    }

}
