package br.com.msystem.db.bo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.msystem.db.entity.Convenio;

@Service
@Transactional
public class ConvenioBo extends AbstractBo<Convenio> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7107561362080611399L;

}