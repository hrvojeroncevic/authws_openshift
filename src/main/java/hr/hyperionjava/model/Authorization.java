package hr.hyperionjava.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Authorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private Timestamp tstamp;
    private String pan;
    private String mid;
    private Integer eurocents;
    private String status;
    private String respcde;

    public Authorization() {
    }

	public Authorization(long id, Timestamp tstamp, String pan, String mid, Integer eurocents,
			String status, String respcde) {
		super();
		this.id = id;
		this.tstamp = tstamp;
		this.pan = pan;
		this.mid = mid;
		this.eurocents = eurocents;
		this.status = status;
		this.respcde = respcde;
	}



	@Override
	public String toString() {
		return "Authorization [id=" + id + ", tstamp=" + tstamp + ", pan=" + pan + ", mid=" + mid
				+ ", eurocents=" + eurocents + ", status=" + status + ", respcde=" + respcde + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getTstamp() {
		return tstamp;
	}

	public void setTstamp(Timestamp tstamp) {
		this.tstamp = tstamp;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public Integer getEurocents() {
		return eurocents;
	}

	public void setEurocents(Integer eurocents) {
		this.eurocents = eurocents;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRespcde() {
		return respcde;
	}

	public void setRespcde(String respcde) {
		this.respcde = respcde;
	}

    

}
