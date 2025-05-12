package org.coding.test.algo.kakako;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static final String DELIMITER_STRING = ", ";

    public static class User {
        private static String COMAPNY_NAME = "example.com";
        private String firstName;
        private String middleName;
        private String lastName;
        private String emailName;

        public User(String f, String l) {
            this.firstName = f; // included -
            this.lastName = l; // only [A-Z][a-z]
            this.middleName = "";
        }


        public void setMiddleName(String m) {
            this.middleName = m;
        }

        public String getFullName() {
            if (middleName.isEmpty()) return firstName + " " + lastName;
            else return firstName + " " + middleName + " " + lastName;
        }

        public void setEmailName() {
            String emailLastName = "";
            if (hasHyphen()) emailLastName = this.lastName.replace("-", "");
            else emailLastName = this.lastName;

            String emailFirstName = firstName.toLowerCase().split("")[0];
            String emailMiddleName = "";
            if (!middleName.isEmpty()) {
                emailMiddleName = middleName.toLowerCase().split("")[0];
            }
            this.emailName = (emailFirstName + emailMiddleName + emailLastName).toLowerCase();
            if (emailName.length() > 10) emailName = emailName.substring(0, 10);
        }

        public String getEmailName() {
            return this.emailName;
        }

        public String makeEmailAddress(int dup) {
            if (dup > 1) emailName += dup;
            return "<" + emailName + "@" + COMAPNY_NAME + ">";
        }

        private boolean hasHyphen() {
            return lastName.contains("-");
        }

    }

    public static void main(String[] args) {
        String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        List<User> users = Arrays.stream(S.split(DELIMITER_STRING)).map(s -> s.split(" "))
                .map(s -> {
                    if (s.length > 2) {
                        User u = new User(s[0], s[2]);
                        u.setMiddleName(s[1]);
                        u.setEmailName();
                        return u;
                    } else {
                        User u = new User(s[0], s[1]);
                        u.setEmailName();
                        return u;
                    }
                }).collect(Collectors.toList());
        Map<String, String> userMap = new LinkedHashMap<>();
        Map<String, Integer> userCountMap = new HashMap<>();
        for (User u : users) {
            if (userCountMap.containsKey(u.getEmailName())) {
                String originalEmail = u.getEmailName();
                int count = userCountMap.get(originalEmail)+1;
                userMap.put(u.getFullName(), u.getFullName() + " " + u.makeEmailAddress(count));
                userCountMap.put(originalEmail, count);
            } else {
                userMap.put(u.getFullName(), u.getFullName() + " " + u.makeEmailAddress(1));
                userCountMap.put(u.getEmailName(), 1);
            }
        }

        System.out.println(userMap.values().stream().collect(Collectors.joining(DELIMITER_STRING)));
        // John Doe <jdoe@example>, Peter Parker <pparker@example>, Mary Jane Watson-Parker <mjwatsonparker@example>, James Doe <jdoe2@example>, John Elvis Doe <jedoe@example>, Jane Doe <jdoe3@example>, Penny Parker <pparker2@example>
        // John Doe <jdoe@example.com&gt;, Peter Parker &lt;pparker@example.com&gt;, Mary Jane Watson-Parker &lt;mjwatsonpa@example.com&gt;, James Doe &lt;jdoe2@example.com&gt;, John Elvis Doe &lt;jedoe@example.com&gt;, Jane Doe &lt;jdoe3@example.com&gt;, Penny Parker &lt;pparker2@example.com&gt;

    }
}
