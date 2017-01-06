package org.example.api.groupkt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RestResponse<T extends Serializable> implements Serializable
{
  private static final long serialVersionUID = -180535742460538575L;

  //@Expose
  //@SerializedName("messages")
  private List<String> messages;

  //@Expose
  //@SerializedName("result")
  private List<T> result;

  public List<String> getMessages()
  {
    return messages;
  }

  public List<T> getResult()
  {
    return result;
  }

  public void setMessages(final List<String> messages)
  {
    this.messages = messages;
  }

  public void setResult(final List<T> result)
  {
    this.result = result;
  }
}
