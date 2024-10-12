package com.keycodehelp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keycodehelp.entities.Invoice;
import com.keycodehelp.exception.ResourceNotFoundException;
import com.keycodehelp.repositories.InvoiceRepository;


@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    // Method to save a new invoice
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    // Method to get an invoice by its ID
    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    // Method to get all invoices
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // Method to update an existing invoice
    public Invoice updateInvoice(Long id, Invoice updatedInvoice) {
        return invoiceRepository.findById(id)
                .map(invoice -> {
                    invoice.setDescription(updatedInvoice.getDescription());
                    invoice.setAmount(updatedInvoice.getAmount());
                    invoice.setPaymentDate(updatedInvoice.getPaymentDate());
                    return invoiceRepository.save(invoice);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id " + id));
    }

    // Method to delete an invoice by its ID
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
