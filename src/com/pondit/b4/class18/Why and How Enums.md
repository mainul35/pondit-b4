### Old school practices

In old days, developers used to use public static final int to define constants and used them from anywhere in the application.
This approach had an issues - they were unable to iterate them in a loop and thus they had to write a long condition or switch-case in order to check the values.

Enum helped developer resolve this issue.

An example of using constants can be:
```JOptionPane.QUESTION_MESSAGE```

### New approach: using enums
By using enums, we can do the same things, but with better ways.

Example as follows:
```
        DayOfWeek dayOfWeek = DayOfWeek.WEDNESDAY;

        Arrays.stream(DayOfWeek.values()).filter(dayOfWeek1 -> dayOfWeek1.equals(dayOfWeek)).forEach(dayOfWeek1 -> {
            System.out.println("Today is "+ dayOfWeek1);
        });
```

Here, DayOfWeek is an enum definition. It contains the days of a week and some helpful methods.
