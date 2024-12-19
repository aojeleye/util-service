package org.util;

import org.util.service.FinanceUtilityServiceImpl;

/**
 * TODO:
 * Add "spill" function
 * Move to github
 * Add README
 * Abstract methods from Main into different classes
 * Add CLI (?)
 */

public class Main {

    public static void main(String[] args) {
        FinanceUtilityServiceImpl financeUtilityServiceImpl = new FinanceUtilityServiceImpl("statements");

        financeUtilityServiceImpl.loadStatements();
        financeUtilityServiceImpl.dumpFile("dump.json");
        financeUtilityServiceImpl.leftovers();
    }
}