package hello;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.validation.Valid;

import org.javault.DefaultVaultRunner;
import org.javault.VaultException;
import org.javault.VaultOutput;
import org.javault.VaultRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class SnippetController extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/")
	public String showForm(SnippetForm snippet) {
		return "form";
	}

	@PostMapping("/")
	public String runSnippet(@Valid SnippetForm snippetForm, BindingResult bindingResult, ModelMap model) {
		System.out.println("Running snippet");

		if (bindingResult.hasErrors()) {
			return "form";
		}

		VaultRunner vaultRunner = new DefaultVaultRunner();
		SnippetOutput snippetOutput;
		try {
			VaultOutput vaultOutput = vaultRunner.runInVault0(snippetForm.getSnippet()).get(30, TimeUnit.SECONDS);
			snippetOutput = new SnippetOutput(vaultOutput);
			System.out.println("Output is: " + vaultOutput.getOutput());
		} catch (VaultException| InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			snippetOutput = new SnippetOutput(e);
		}
		model.addAttribute("snippetOutput", snippetOutput);
		return "results";
	}
}
