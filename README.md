# PolicyProj
Analyze Teenage Birthrate Data in US States to determine effectiveness of certain Sexual Education Policies

How it works: 

The states of the U.S. have many different types of Sexual Education Policy. For this project,
  each state was categorized into one of ten different kinds of Sex Ed Policy in effect in the U.S. The average
  teenage birthrate linked to each policy tier was then calculated.
  
Sex Ed Policy Tier List:
  1. Sex Ed is taught voluntarily, with no specific focus on abstinence or contraceptives (Special Tier; East Coast)
    States: CT, MA, NH, NY, PA 
  2. Sex Ed is mandatory, and must stress abstinence while covering contraception.
    States: DE, ME, NJ, OR, RI
  3. Sex Ed is mandatory, and must cover Abstinence and contraception.
    States: CA, HI, MD, VT
  4. Sex Ed is taught voluntarily, but must cover abstinence and contraception
    States: CO, VA
  5. Sex Ed is mandatory, but there are no specific requirements
    States: IA, NV
  6. Sex Ed is taught voluntarily, with no specific focus on abstinence or contraceptives (Non East Coast)
    States: AK, ID, KS, NE, SD, WY
  7. Sex Ed is mandatory, must only cover abstinence
    States: KY, MT, ND
  8. Sex Ed is mandatory, must stress abstinence
    States:  GA, MS, OH, TN
  9. Sex Ed is taught voluntarily, but must stress abstinence while covering contraception
    States:  AL, IL
  10. Sex Ed is taught voluntarily, but must stress abstinence
    States: AZ, AR, IN, LA, MO, OK, TX, FL, MI,  WI


The input.txt file containing the following State Data for each U.S. State is parsed by Model.java:
  - Number of teenage births in a state
  - Population of state 
  - Rate of change of state population population
  - Teenage birthrate of the State
  - Average birthrate found in proposed policy
(note that this information is sources from the Kaiser Family Foundation)
  
Model.java then asks the User to input:
  A. The State they want to perform the test on
  B. The Sexual Education Policy that the state will potentially switch to
  C. The timeframe in which the effects of the policy change will be measured
  D. In how many years said policy will take to get into effect
  
Once run, Model.java parses each line of input.txt, and converts the data to the State.java data type.
Once the user input is determined, Model.java outputs the predicted teenage births per year if the Sex Ed Policy
does not change, and then the predicted teenage births per year with the implementation of the policy. This data
is then saved as a .txt file.

Result:
  This model shows the benefits a state can have by updating their Sex Ed policy. It can also be used to model the 
  negative effects of switching from a robust policy to a weaker one.
  
Model.java
  Main Class of project. Runs analysis on data given by input.txt, and outputs results to a .txt file

State.java
  State Data Type. A convenient way to have all values associated with a state to be in the same
  data type.
  
input.txt
  Contains state data to be parsed by Model.java and stored as State Data Types.
  
MS-4-30-4.txt
  Example output. 
  Model of Missisippi switching to a Policy of tier 4 in 4 years, over the course of 30 years.
