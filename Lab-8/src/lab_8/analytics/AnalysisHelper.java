/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_8.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lab_8.entities.Comment;
import lab_8.entities.Post;
import lab_8.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {

//    static <K, V extends Comparable<? super V>>
//            SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
//        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
//                new Comparator<Map.Entry<K, V>>() {
//            @Override
//            public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
//                int res = e1.getValue().compareTo(e2.getValue());
//                return res != 0 ? res : 1;
//            }
//        }
//        );
//        sortedEntries.addAll(map.entrySet());
//        return sortedEntries;
//    }
    public void userWithMostLikes() {
        Map<Integer, Integer> userLikeCount = new HashMap<>();

        Map<Integer, User> users = DataStore.getInstance().getUsers();

        for (User user : users.values()) {
            for (Comment comment : user.getComments()) {
                int likes = 0;
                if (userLikeCount.containsKey(user.getId())) {
                    likes = userLikeCount.get(user.getId());
                }
                likes += comment.getLikes();
                //System.out.println(comment.getLikes());
                userLikeCount.put(user.getId(), likes);
            }

            //System.out.println("User with maximum number of Likes is " + user.getId() + " is " + userLikeCount.get(user.getId()));
        }

        int userIdWithMaxLikes = -1;
        int maxLikesCount = -1;
        for (Map.Entry<Integer, Integer> entry : userLikeCount.entrySet()) {
            if (userIdWithMaxLikes == -1) {
                userIdWithMaxLikes = entry.getKey();
            }

            if (maxLikesCount < entry.getValue()) {
                userIdWithMaxLikes = entry.getKey();
                maxLikesCount = entry.getValue();
            }
        }

        if (userIdWithMaxLikes == -1) {
            System.out.println("No users found in the data. Please check.");

        } else {
            //Printing the user with Maximum likes
            User user = users.get(userIdWithMaxLikes);
            System.out.println("User with maximum likes is : " /* + user.getFirstName() + " " + user.getLastName() + " and has ID: "*/
                    + user + " with " + maxLikesCount + " likes.");
        }

    }

    public void getFiveMostLikedComment() {

        Map<Integer, Comment> commentMap = DataStore.getInstance().getComments();

        List<Comment> commentList = new ArrayList<>(commentMap.values());

        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                //Desceding list
                return o2.getLikes() - o1.getLikes();
            }
        });

        String leftAlignFormat = "| %-4d | %-30s | %-5d | %-6d | %-6d |%n";
        System.out.format("+------+--------------------------------+-------+--------+--------+%n");
        System.out.format("| ID   | TEXT                           | Likes | PostId | UserId |%n");
        System.out.format("+------+--------------------------------+-------+--------+--------+%n");

        //Displaying the 5 most liked comments
        for (int i = 0; i < 5; i++) {
            Comment currComment = commentList.get(i);
            System.out.format(leftAlignFormat, currComment.getId(), currComment.getText(), currComment.getLikes(),
                    currComment.getPostId(), currComment.getUserId());
        }
        System.out.format("+------+--------------------------------+-------+--------+--------+%n");
    }

    public void averageNumOfLikesPerComment() {
        int totalNumOfComment = DataStore.getInstance().getComments().size();
        int totalNumOfLikes = 0;
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();

        for (Comment comment : comments.values()) {
            totalNumOfLikes += comment.getLikes();
        }

        System.out.println("Average Like Count per comment is : " + (int) totalNumOfLikes / totalNumOfComment);

    }


}
