package com.github.ksoichiro.note.web.note;

import com.github.ksoichiro.note.entity.Note;
import com.github.ksoichiro.note.service.NoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping("/")
    public String list(Model model) {
        model.addAttribute("list", noteService.findAll());
        return "note/list";
    }

    @RequestMapping("/note/create")
    public String create(@ModelAttribute NoteForm form) {
        return "note/create";
    }

    @RequestMapping(value = "/note/save", method = RequestMethod.POST)
    public String save(@ModelAttribute NoteForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return create(form);
        }
        Note entity = new Note();
        BeanUtils.copyProperties(form, entity);
        noteService.create(entity);
        return "redirect:/";
    }

    @RequestMapping("/note/edit/{id}")
    public String edit(@PathVariable Integer id, @ModelAttribute NoteForm form) {
        BeanUtils.copyProperties(noteService.find(id), form);
        return "note/edit";
    }

    @RequestMapping(value = "/note/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Integer id, @ModelAttribute NoteForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return edit(id, form);
        }
        Note entity = new Note();
        BeanUtils.copyProperties(form, entity);
        entity.setId(id);
        noteService.update(entity);
        return "redirect:/";
    }
}
