package org.util.service;

public interface FinanceUtilityService {

    void loadStatements();

    void dumpStdout();

    void dumpFile(String outputFileName);

    void leftovers();
}
