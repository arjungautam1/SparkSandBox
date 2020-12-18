package status;

public enum StatusResponse {

    SUCCESS("Succss"),
    ERROR("Error");

    final private String status;
    StatusResponse(String status){
        this.status=status;
    }

    public String getStatus(){
        return status;
    }
}
