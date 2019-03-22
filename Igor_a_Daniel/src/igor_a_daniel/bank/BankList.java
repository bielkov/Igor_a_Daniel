/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igor_a_daniel.bank;

import igor_a_daniel.bank.Bank;
import java.util.ArrayList;

/**
 *
 * @author Игорь
 */
public class BankList {
    private ArrayList<Bank> list = new ArrayList<>();

    public void setList(ArrayList<Bank> list) {
        this.list = list;
    }

    public ArrayList<Bank> getList() {
        return list;
    }
    
    public void clearList(){
        list.clear();
    }
    
}
