class UserNode {
    int userId;
    String name;
    int age;
    int[] friends = new int[10]; // store friend IDs
    int friendCount = 0;
    UserNode next;
    UserNode(int id, String name, int age) {
        this.userId = id;
        this.name = name;
        this.age = age;
        this.next = null;
    }
}
// Linked List class
class SocialMedia {
    UserNode head;
    // Add user
    void addUser(int id, String name, int age) {
        UserNode newNode = new UserNode(id, name, age);
        if (head == null) {
            head = newNode;
            return;
        }
        UserNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    // Find user by ID
    UserNode findUser(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    // Add friend connection
    void addFriend(int id1, int id2) {

        UserNode u1 = findUser(id1);
        UserNode u2 = findUser(id2);
        if (u1 != null && u2 != null) {
            u1.friends[u1.friendCount++] = id2;
            u2.friends[u2.friendCount++] = id1;
        }
    }
    // Remove friend connection
    void removeFriend(int id1, int id2) {

        UserNode u1 = findUser(id1);
        UserNode u2 = findUser(id2);

        if (u1 != null && u2 != null) {
            removeFromList(u1, id2);
            removeFromList(u2, id1);
        }
    }
   // Helper method
    void removeFromList(UserNode user, int id) {

        for (int i = 0; i < user.friendCount; i++) {
            if (user.friends[i] == id) {
                user.friends[i] = user.friends[user.friendCount - 1];
                user.friendCount--;
                return;
            }
        }
    }
    // Display friends of user
    void displayFriends(int id) {

        UserNode user = findUser(id);

        if (user == null) return;

        System.out.println("Friends of " + user.name + ":");
        for (int i = 0; i < user.friendCount; i++) {
            System.out.println(user.friends[i]);
        }
    }
    // Mutual friends
    void mutualFriends(int id1, int id2) {
        UserNode u1 = findUser(id1);
        UserNode u2 = findUser(id2);

        System.out.println("Mutual Friends:");

        for (int i = 0; i < u1.friendCount; i++) {
            for (int j = 0; j < u2.friendCount; j++) {
                if (u1.friends[i] == u2.friends[j]) {
                    System.out.println(u1.friends[i]);
                }
            }
        }
    }
    // Search user
    void searchUser(String key) {

        UserNode temp = head;

        while (temp != null) {
            if (temp.name.equals(key) || String.valueOf(temp.userId).equals(key)) {
                System.out.println(temp.name + " Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }

        System.out.println("User not found");
    }
    // Count friends
    void countFriends() {

        UserNode temp = head;

        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendCount + " friends");
            temp = temp.next;
        }
    }
}
public class SocialMediaApp {
    public static void main(String[] args) {

        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Rahul", 21);
        sm.addUser(2, "Amit", 22);
        sm.addUser(3, "Neha", 20);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);

        sm.displayFriends(1);
        sm.mutualFriends(1, 2);
        sm.countFriends();
    }
}

