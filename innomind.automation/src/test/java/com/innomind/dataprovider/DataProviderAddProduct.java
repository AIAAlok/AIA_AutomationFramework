package com.innomind.dataprovider;

import com.innomind.constants.FrameworkConstants;
import com.innomind.helpers.ExcelHelpers;
import com.innomind.helpers.Helpers;
import org.testng.annotations.DataProvider;

public class DataProviderAddProduct {
    @DataProvider(name = "data_provider_add_product")
    public Object[][] dataAddProduct() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_ABI_DATA, "AddProduct", 2, 2);
        return data;
    }
}
