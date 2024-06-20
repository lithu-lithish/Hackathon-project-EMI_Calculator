Feature: Car Loan

Scenario Outline: Validating car loan calculation

Given user click car loan
And send car loan amount value as <1>
And send interest rate as <2>
And send loan tensure as <3>
When press enter
Then Display the interest amount and principle amount of first month

Examples:
		|1|2|3|
		|1500000|9.5|1|