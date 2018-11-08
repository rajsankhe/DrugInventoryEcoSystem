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

public void postWithMostNumComments() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();

        List<Post> postList = new ArrayList<>(posts.values());

        Collections.sort(postList, new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return o2.getComments().size() - o1.getComments().size();
            }
        });

        System.out.println("Post with maximum number of comments is:");
        System.out.println("ID: " + postList.get(0).getPostId() + " Posting User ID: " + postList.get(0).getUserId()
                + " Number of Comments: " + postList.get(0).getComments().size());

//        for (Post post : postList) {
//            System.out.println("ID: " + post.getPostId() + " Posting User ID: " + post.getUserId()
//                    + " Number of Comments: " + post.getComments().size());
//        }
    }

    public void postWithMostLikedComment() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();

        int postWithMostLikedComments = -1;
        int totalNumOfLikesForComments = -1;

        for (Map.Entry<Integer, Post> entry : posts.entrySet()) {
            int currSumOfLikes = 0;
            Post p = entry.getValue();
            for (Comment c : p.getComments()) {
                currSumOfLikes += c.getLikes();
            }

            if (totalNumOfLikesForComments == -1) {
                postWithMostLikedComments = entry.getKey();
                totalNumOfLikesForComments = currSumOfLikes;
            } else {
                if (currSumOfLikes > totalNumOfLikesForComments) {
                    totalNumOfLikesForComments = currSumOfLikes;
                    postWithMostLikedComments = entry.getKey();
                }
            }

        }

        System.out.println("Post with maximum number of comments is:" + postWithMostLikedComments);

        Post post = DataStore.getInstance().getPosts().get(postWithMostLikedComments);

        System.out.println("ID: " + post.getPostId() + " Posting User ID: " + post.getUserId()
                + " Number of Comments: " + post.getComments().size() + " Total number of Likes: " + totalNumOfLikesForComments);

    }

    public void topFiveInactiveUserBasedOnPosts() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        //Map<Integer, Integer> userPostCount = new HashMap<>();
        Map<Integer, Integer> userPostCount = new HashMap<>();

        for (Post p : posts.values()) {
            int userId = p.getUserId();
            if (userPostCount.containsKey(userId)) {
                //add 1 to the value
                userPostCount.put(userId, userPostCount.get(userId) + 1);
            } else {
                userPostCount.put(userId, 1);
            }
        }

        LinkedHashMap<Integer, Integer> sortedMap
                = userPostCount.entrySet().stream().
                        sorted(Entry.comparingByValue()).
                        collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));

        int i = 0;
        System.out.println("5 Most inactive Users based on number of posts");
        System.out.println("User | Post Count");

        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            User user = DataStore.getInstance().getUsers().get(entry.getKey());
            System.out.println(user.toString() + "|" + entry.getValue());
            i++;
            if (i > 4) {
                break;
            }
        }

    }

    public void topFiveInactiveUserBasedOnComments() {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        List<User> userList = new ArrayList<>(users.values());

        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getComments().size() - o2.getComments().size();
            }
        });

        System.out.println("Top 5 Inactive User(based on comments):");
        for (int i = 0; i < 5; i++) {
            System.out.println(userList.get(i));
        }

//                + " with comment count :" + users.get(userList.get(0).getId()).getComments().size());
    }


}
