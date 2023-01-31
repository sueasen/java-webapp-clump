package dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * {@link UserInfo}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {

  List<Users> results;

  /**
   * users を設定します
   * @param users ユーザ情報リスト
   */
  public void setResults(List<Users> results) {
    this.results = results;
  }

  /**
   * users を取得します
   * @return users
   */
  public List<Users> getResults() {
    return results;
  }

  /**
   * {@link Users}
   */
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Users {

    Picture picture;

    /**
     * picture を設定します
     * @param picture picture情報
     */
    public void setLarge(Picture picture) {
      this.picture = picture;
    }

    /**
     * picture を取得します
     * @return picture
     */
    public Picture getPicture() {
      return picture;
    }
  }

  /**
   * {@link Users}
   */
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Picture {

    String large;

    /**
     * large を設定します
     * @param large large画像
     */
    public void setLarge(String large) {
      this.large = large;
    }

    /**
     * large を取得します
     * @return large
     */
    public String getLarge() {
      return large;
    }
  }
}
