/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igor_a_daniel.bank;

/**
 *
 * @author Игорь
 */
public interface ICurrency {
    public void nameCurrency(String name);
    public void country(String state);
    public void abbreviation(String abb);
    public double buy(double value);
    public double sale(double value);
    public double isChange(double value);
}
