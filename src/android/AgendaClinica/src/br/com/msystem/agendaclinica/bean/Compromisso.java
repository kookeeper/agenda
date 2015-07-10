package br.com.msystem.agendaclinica.bean;

import java.io.Serializable;
import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class Compromisso implements Serializable, Parcelable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2709443002207694359L;
	
	private Parcelable.Creator<Compromisso> CREATOR;
	
	private Integer id;
	private Pessoa paciente;
	private Pessoa medico;
	private Date dataCompromisso;

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public Pessoa getPaciente() {

		return paciente;
	}

	public void setPaciente(Pessoa paciente) {

		this.paciente = paciente;
	}

	public Pessoa getMedico() {

		return medico;
	}

	public void setMedico(Pessoa medico) {

		this.medico = medico;
	}

	public Date getDataCompromisso() {

		return dataCompromisso;
	}

	public void setDataCompromisso(Date dataCompromisso) {

		this.dataCompromisso = dataCompromisso;
	}

	@Override
	public int describeContents() {

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		// TODO Auto-generated method stub
		
	}

	public Parcelable.Creator<Compromisso> getCREATOR() {

		return CREATOR;
	}

	public void setCREATOR(Parcelable.Creator<Compromisso> cREATOR) {

		CREATOR = cREATOR;
	}

}
