package CurrencyConverter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyConverter {
	//We declare all currency exchanges and their value in dollar.
	private String [][] currenciesCountries = {
			{"US"  , "1"},
			{"MXN" , "16.95"},
			{"EUR" , "0.89"},
			{"GBP" , "0.77"},
			{"JPY" , "141.67"},
			{"KRW" , "1286.74"}
	};

	public String[][] getCurrenciesCountries() {
		return currenciesCountries;
	}

	public void setCurrenciesCountries(String[][] currenciesCountries) {
		this.currenciesCountries = currenciesCountries;
	}
	//Method to get the value of one dollar depend of country.
	public Double findCurrencyValue(String country) {
        for (String[] currency : currenciesCountries) {
            if (currency[0].equalsIgnoreCase(country)) {
                return Double.parseDouble(currency[1]);
            }
        }
        return null; // Return null if the country is not found in the matrix
    }
	//Method to make the conversion
	public String converterCurrency(Double amount,String countryFrom, String countryTo) {
		Double currencyFrom = this.findCurrencyValue(countryFrom);
		Double currencyTo = this.findCurrencyValue(countryTo);
		
		Double conversion = (amount * (currencyTo / currencyFrom));
		return String.format("%.4f", conversion);
	}
	public String getContentInParenthesis(String input) {
		Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
	}
}
