package br.com.msystem.exception;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.faces.view.facelets.TagAttributeException;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {
	private ExceptionHandler wrapped;

	public CustomExceptionHandler(ExceptionHandler wrapped) {

		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {

		return wrapped;
	}

	@Override
	public void handle() throws FacesException {

		Iterator<ExceptionQueuedEvent> iterator = getUnhandledExceptionQueuedEvents()
				.iterator();

		boolean redireciona = false;

		FacesContext fc = FacesContext.getCurrentInstance();

		while (iterator.hasNext()) {
			ExceptionQueuedEvent event = (ExceptionQueuedEvent) iterator.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event
					.getSource();

			Throwable throwable = context.getException();

			if (throwable instanceof TagAttributeException) {
				redireciona = true;
			}

			if (throwable instanceof ViewExpiredException) {
				redireciona = true;
			}

			try {
				Flash flash = fc.getExternalContext().getFlash();

				// Put the exception in the flash scope to be displayed in the
				// error page if necessary ...
				flash.put("errorDetails", throwable.getMessage());

				System.out.println("the error is put in the flash: "
						+ throwable.getMessage());

				String mensagem = throwable.getMessage();
				String detalhe = "";
				if (throwable.getCause() != null) {
					detalhe = throwable.getCause().getMessage();
				}

				fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						mensagem, detalhe));
				fc.getExternalContext().getFlash().setKeepMessages(true);

				if (redireciona) {
					
					NavigationHandler navigationHandler = fc.getApplication()
							.getNavigationHandler();
					navigationHandler.handleNavigation(fc, null, "error?faces-redirect=true");
/*
					try {
						fc.getExternalContext().redirect(
								"/" + fc.getExternalContext().getContextName()
										+ "/error.xhtml");
					} catch (IOException e) {
						fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_FATAL,
								e.getMessage(), e.getLocalizedMessage()));
						e.printStackTrace();
					}
*/
					fc.renderResponse();

				}

			} finally {
				iterator.remove();
			}
		}

		// Let the parent handle the rest
		getWrapped().handle();
	}
}