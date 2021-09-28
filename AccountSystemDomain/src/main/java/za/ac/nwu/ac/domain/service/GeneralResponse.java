package za.ac.nwu.ac.domain.service;

import java.io.Serializable;
import java.util.Objects;

public class GeneralResponse<T> implements Serializable
{
    private static final long serialVersionUID = -6303885155426610140L;
    private final boolean successful;
    private final transient T payload;

    public GeneralResponse(boolean successful, T payload)
    {
        this.successful = successful;
        this.payload = payload;
    }
    public boolean isSuccessful()
    {
        return successful;
    }

    public T getPayload()
    {
        return payload;
    }

    @Override
    public  boolean equals(Object o)
    {
        if (this == o) return true;
        if (o== null || getClass() != o.getClass()) return false;
        za.ac.nwu.ac.domain.service.GeneralResponse<?> that = (za.ac.nwu.ac.domain.service.GeneralResponse<?>) o;
            return successful == that.successful && Objects.equals(payload, that.payload);
    }

    public int hasCode()
    {
        return Objects.hash(successful, payload);
    }

    @Override
    public String toString()
    {
        return "GeneralResponse{" +
                "successful=" + successful +
                ", payload=" + payload +
                "}";
    }

}


