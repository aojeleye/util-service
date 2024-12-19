package org.util.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;
import org.util.Main;
import org.util.data.FinancialMonthDto;
import org.util.data.FinancialYearDto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static org.util.constants.Constants.*;
import static org.util.constants.Constants.ENTITY_NAME_INDEX;

public class FinanceUtilityServiceImpl {

    private String directory;
    private ObjectMapper objectMapper;
    private Map<String, FinancialYearDto> financialYearMap;
    private Set<String> unlistedItems;

    public FinanceUtilityServiceImpl(String directory) {
        this.directory = directory;
        this.objectMapper = new ObjectMapper();
        this.financialYearMap = new HashMap<>();
        this.unlistedItems = new HashSet<>();
    }

    public void loadStatements() {
        try {
            URL resource = Main.class.getClassLoader().getResource(directory);
            File statementsFolder = new File(resource.toURI());

            for (final File file : statementsFolder.listFiles()) {
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String transaction = myReader.nextLine();
                    String[] transactionArray = transaction.replaceAll("\"", "").split(",");
                    String dateStr = transactionArray[0];
                    FinancialYearDto currentFinancialYearDto = getFinYearDto(dateStr, financialYearMap);
                    FinancialMonthDto currentFinancialMonthDto = getFinMonthDto(dateStr, currentFinancialYearDto);
                    fillBucket(transactionArray, currentFinancialMonthDto.getBuckets(), unlistedItems);
                }
                myReader.close();
            }
        } catch (URISyntaxException | FileNotFoundException | NullPointerException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Returns itemized list in JSON format as a string.
     */
    public void dumpStdout() {
        dumpFile("");
    }

    /**
     * Writes itemized JSON structure to provided file name under target folder
     */
    public void dumpFile(String outputFileName) {
        try {
            for (FinancialYearDto yearDto : financialYearMap.values()) {
                for (FinancialMonthDto monthDto : yearDto.getMonths()) {
                    monthDto.emptyBucket();
                    monthDto.calcBal();
                }
            }
            String financialYearsStr = objectMapper.writeValueAsString(financialYearMap.values());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement je = JsonParser.parseString(financialYearsStr);
            String dumpText = gson.toJson((je));

            if (StringUtils.isEmpty(outputFileName)) {
                System.out.println(dumpText);
            } else {
                String targetFolderPath = "target/"; // Path relative to your project root

                // Create the target folder if it doesn't exist
                File targetFolder = new File(targetFolderPath);
                if (!targetFolder.exists()) {
                    targetFolder.mkdirs();
                }

                // Create the file within the target folder
                Path filePath = Path.of(targetFolderPath, outputFileName);
                Files.writeString(filePath, dumpText);

                System.out.println("File created successfully at: " + filePath.toAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }

    public void leftovers() {
        if (!unlistedItems.isEmpty()) {
            System.out.println("--- UNLISTED ITEMS ---");
            unlistedItems.forEach(System.out::println);
        } else {
            System.out.println("--- ALL ITEMS LISTED ---");
        }
    }

    private static FinancialMonthDto getFinMonthDto(String dateStr, FinancialYearDto currentFinancialYearDto) {
        String[] dateArr = dateStr.split("-");
        String currentMonth = monthMap.get(dateArr[1]);
        FinancialMonthDto currentfinancialMonthDto = currentFinancialYearDto.getMonth(currentMonth);

        if (currentfinancialMonthDto == null) {
            currentfinancialMonthDto = new FinancialMonthDto();
            currentfinancialMonthDto.setMonth(currentMonth);
            currentFinancialYearDto.getMonths().add(currentfinancialMonthDto);
            return currentfinancialMonthDto;
        } else {
            return currentfinancialMonthDto;
        }
    }

    private static FinancialYearDto getFinYearDto(String dateStr, Map<String, FinancialYearDto> financialYearMap) {
        String[] dateArr = dateStr.split("-");
        String currentYear = dateArr[0];

        FinancialYearDto currentFinancialYearDto = financialYearMap.get(currentYear);

        if (currentFinancialYearDto != null) {
            return currentFinancialYearDto;
        } else {
            FinancialYearDto newFinancialYearDto = new FinancialYearDto();
            newFinancialYearDto.setYear(currentYear);
            financialYearMap.put(currentYear, newFinancialYearDto);
            return newFinancialYearDto;
        }
    }

    private static void fillBucket(String[] transaction, Map<String, BigDecimal> buckets, Set<String> unlistedItems) {
        if (doesContain(INCOME_ENTITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(INCOME, buckets.get(INCOME).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (doesContain(DINING_OUT_ENTITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(DINING_OUT, buckets.get(DINING_OUT).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (doesContain(BILL_ENTITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(BILLS, buckets.get(BILLS).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (doesContain(ENTERTAINMENT_ENTITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(ENTERTAINMENT, buckets.get(ENTERTAINMENT).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (doesContain(PET_ENTITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(PET, buckets.get(PET).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (doesContain(MISC_ENTITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(MISC, buckets.get(MISC).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (doesContain(GAS_STATION_ENTITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(GAS_STATION, buckets.get(GAS_STATION).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (doesContain(HOME_REPAIR_ENTITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(HOME_REPAIR, buckets.get(HOME_REPAIR).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (doesContain(CAR_REPAIR_ENTITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(CAR_REPAIR, buckets.get(CAR_REPAIR).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (doesContain(GROCERIES_ENTITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(GROCERIES, buckets.get(GROCERIES).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (doesContain(TRAVEL_ENTITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(TRAVEL, buckets.get(TRAVEL).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (doesContain(CLOTHES_ENTITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(CLOTHES, buckets.get(CLOTHES).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (doesContain(HEALTHCARE_ENTITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(HEALTHCARE, buckets.get(HEALTHCARE).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (doesContain(TAX_ENITY_LIST, transaction[ENTITY_NAME_INDEX])) {
            buckets.put(TAX, buckets.get(TAX).add(new BigDecimal(transaction[AMOUNT_INDEX])));
        } else if (!doesContain(IGNORE_ITEM_LIST, transaction[ENTITY_NAME_INDEX])) {
            unlistedItems.add(transaction[ENTITY_NAME_INDEX]);
        }
    }

    private static boolean doesContain(List<String> entities, String transactionEntity) {
        for (String entity : entities) {
            if (transactionEntity.startsWith(entity)) {
                return true;
            }
        }

        return false;
    }
}
