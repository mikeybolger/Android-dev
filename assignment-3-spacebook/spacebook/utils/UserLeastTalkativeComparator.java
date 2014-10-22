package utils;

import java.util.Comparator;

import models.User;

public class UserLeastTalkativeComparator implements Comparator<User>
{
  @Override
  public int compare(User a, User b)
  {
    return Integer.compare(a.outbox.size(),b.outbox.size());
  }
}
