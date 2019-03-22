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
public class Bank implements ICurrency {

    private String nameBank;

    public Bank(String nameBank) {
        this.nameBank = nameBank;
    }

   

    public String getNameBank() {
        return nameBank;
    }

    @Override
    public void nameCurrency(String name) {
        this.nameCurrency(name);
    }

    @Override
    public void abbreviation(String abb) {
        this.abbreviation(abb);
    }

    @Override
    public double buy(double value) {
        return this.buy(value);
    }

    @Override
    public double sale(double value) {
        return this.sale(value);
    }

    @Override
    public double isChange(double value) {
        return this.isChange(value);
    }

    @Override
    public void country(String state) {
        this.country(state);
    }

}
