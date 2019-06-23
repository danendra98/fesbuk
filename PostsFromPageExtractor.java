import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class PostsFromPageExtractor {

public static void main(String[] args) throws FacebookException {

 // Generate facebook instance.
Facebook facebook = new FacebookFactory().getInstance();
// Use default values for oauth app id.
facebook.setOAuthAppId("330071804554962", "e24b1bdbe92e6d31b37865ddea35d151");
// Get an access token from: 
// https://developers.facebook.com/tools/explorer
// Copy and paste it below.
String accessTokenString = "EAAEsMtSpLtIBAMhbV3qznad97LNDAwZBpWMla40n7JMl9OelnvzPBUZCNsgCYf090cZBWBG08lx6jZCeCdFovKw6jC5wFhSTNFyl1mVjhhxLaztctBrDBBgZBvdH6XuCHdx9Hve7F7XZBQaKZApy6S37WHlsYzeXNZBMtUZCtOXWMhVlrvKWpxi7rFsBkBtXp3gkZD";
AccessToken at = new AccessToken(accessTokenString);
// Set access token.
facebook.setOAuthAccessToken(at);

 // We're done.
// Access group feeds.
// You can get the group ID from:
// https://developers.facebook.com/tools/explorer

 // Set limit to 25 feeds.

 ResponseList< Post > feeds = facebook.getFeed("2761417847218937",
new Reading().limit(25));

 // For all 25 feeds...
for (int i = 0; i < feeds.size(); i++) {
// Get post.
Post post = feeds.get(i);
// Get (string) message.
String message = post.getMessage();
// Print out the message.
System.out.println(message);
PagableList comments = post.getComments();
String date = post.getCreatedTime().toString();
// String name = post.getFrom().getName();
String id = post.getId();
System.out.println(date);
System.out.println(id);
}
 }	
}