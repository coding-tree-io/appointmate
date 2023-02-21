# Back-End MVP for an Appointment Booking Application

## 1. Business Registration

- [ ] Allow businesses to register with the application by providing basic details like name, address, and contact
  information.
- [ ] Define API endpoints for business registration that accept and store the required details in a database.

  ### Sub-items
    - [ ] Define an API that allows businesses to register with the application.
    - [ ] Define an API that allows businesses to update their contact information.
    - [ ] Define an API that allows businesses to view their contact information.
    - [ ] Define an API that allows businesses to delete their account.
    - [ ] Define an API that allows businesses to view a list of their upcoming appointments.
    - [ ] Define an API that allows businesses to view a list of their past appointments.
    - [ ] Define an API that allows businesses to view a list of their clients.
    - [ ] Define an API that allows businesses to view a list of their services.

## 2. Appointment Booking System

- [ ] Allow businesses to define their services and availability.
- [ ] Allow clients to view and book appointments through API endpoints exposed by the business.
- [ ] Store appointment bookings in a database.

  ### Sub-items
    - [ ] Define an API that allows businesses to create and manage their services.
    - [ ] Define an API that allows businesses to specify their availability for each service they offer.
    - [ ] Define an API that allows businesses to set limits on the number of appointments they can accept per
      day/week.
    - [ ] Define an API that allows businesses to block out time slots that they are unavailable.
    - [ ] Define an API that allows clients to browse and view the availability of the business's services.
    - [ ] Define an API that allows clients to book appointments at available time slots.
    - [ ] Define an API that allows businesses to set offset (in hours) for first available slot.
    - [ ] Send email notification to business, after successful booking.
    - [ ] Send email notification to client (with link to modify / cancel), after successful booking.
    - [ ] Send email notification/ reminder to business / client, X time before the booked appointment.

## 3. Client Management System

- [ ] Allow businesses to manage their clients' information and appointments.
- [ ] Allow businesses to update client information and appointment details.
- [ ] Store client information and appointment details in a database.

  ### Sub-items
    - [ ] Define an API that allows businesses to view a list of their clients and their contact information.
    - [ ] Define an API that allows businesses to view a list of upcoming appointments and their details.
    - [ ] Define an API that allows businesses to cancel or reschedule appointments.
    - [ ] Define an API that allows businesses to mark appointments as complete or no-show.

## 4. User Authentication

- [ ] Allow clients to register and authenticate themselves using social login to access the business's API endpoints to
  book appointments.
- [ ] Integrate social login into the application for clients to register and authenticate themselves.
- [ ] Store additional client information and authentication details if needed.

  ### Sub-items
    - [ ] Define an API that allows clients to register and log in to the application using social media accounts.
    - [ ] Define an API that allows clients to view their upcoming appointments.
    - [ ] Define an API that allows clients to cancel or reschedule appointments.
    - [ ] Define an API that allows clients with a history of their past appointments.
