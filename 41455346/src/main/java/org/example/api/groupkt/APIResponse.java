package org.example.api.groupkt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public abstract class APIResponse<T extends Serializable> implements Serializable
{
  private static final long serialVersionUID = 5625266522926884107L;

  @Expose
  @SerializedName("RestResponse")
  private RestResponse<T> restResponse;

  public RestResponse<T> getRestResponse()
  {
    return restResponse;
  }

  public void setRestResponse(final RestResponse<T> restResponse)
  {
    this.restResponse = restResponse;
  }
}
