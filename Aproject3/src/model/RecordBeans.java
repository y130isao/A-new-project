package model;

import java.io.Serializable;

public class RecordBeans implements Serializable {

    private String example_list;
    private String do_result;
    private String memo_list;
    
    public String getExample_list() {
        return example_list;
    }
    public void setExample_list(String example_list) {
        this.example_list = example_list;
    }
    public String getDo_result() {
        return do_result;
    }
    public void setDo_result(String do_result) {
        this.do_result = do_result;
    }
    public String getMemo_list() {
        return memo_list;
    }
    public void setMemo_list(String memo_list) {
        this.memo_list = memo_list;

    }
}

