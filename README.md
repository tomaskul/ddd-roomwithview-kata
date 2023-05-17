# ddd-roomwithview-kata
Loose, [Neil Ford's 'Room with a View' kata](https://nealford.com/katas/kata?id=RoomWithAView) implementation using [Domain-Driven Design](https://en.wikipedia.org/wiki/Domain-driven_design) principles. Only a sub-set of the kata is addressed in this repository. Primary aim here to put DDD into practice via a workable example. DDD-specific katas I've seen to-date, were either too simplistic or too complex for my learning needs and this one seems to be at the right level of complexity. 

# Glossary
## Primary
Terms deemed relevant for the implemented aspects of the kata. Other extracted terms can be found in omitted sub-section below.

| Term | Context | Definition | Questions |
| --- | --- | --- | --- |
| Reservation & management system | n/a | Multi-venue, room viewing and reservation system (standard booking functionality via existing system) | |
| Guest | n/a | Person who views & reserves a stay at the selected venue & room | Can venue be booked on someone else' behalf? Is venue & room most appropriate terms? |
| Venue | n/a | Venue available for reservation | |
| Room | n/a | Place reserved and stayed in by the guest at specific venue (high-end resorts and spas current focus) | Is this the best term? Are/will multi-room options be available? |
| Room status | n/a | booked/available/~~ready to clean/~~etc/when room will be needed next | |
| | n/a | | |

## Omitted
| Term | Context | Definition | Questions |
| --- | --- | --- | --- |
| Housekeeping management functionality | n/a | | |
| Room priority & reservation | n/a | | clean the room that's booked & needed soonest? |
| Staff | n/a | | |
| Cleaning & maintenance staff | n/a | | |
| Cleaning cart | n/a | Cart containing cleaning supplies and fresh sheets | |
| Cleaning staff directions device | n/a | Proprietary devices attached to cleaning carts, indicating which room to clean next | |
| Room status | n/a | ready to clean/etc/when room will be needed next | relates to priority? |

# Domain Events
1. ~~Viewing~~ (Viewing isn't part of Command stack)
   1. ~~all venues~~
   1. ~~view specific venue~~
   1. ~~view specific room at a specific venue~~
   1. ~~view venues with availability by date~~
   1. ~~view venues with availability by room type~~
1. GuestRegistrationCompleted (handled by 'existing reservations service')  
1. Reservation (all require venue choice and reservation period) (precursor: GuestRegistrationCompleted)
   1. By specific room choice
   1. By room type choice
   1. 
1. ReservationPaymentProcessed (handled by 'existing reservations service') (precursor: Reservation)
1. ReservationPaymentFailed (handled by 'existing reservations service') (precursor: Reservation)
1. Reservation confirmation (precursor: Reservation & ReservationPaymentProcessed)
1. Reservation cancellation (precursor: Reservation): Can be cancelled by guest, venue, the booking system, expiration
1. Get next availability of a room (may be ignored for this implementation)
   1. For specific room at a venue
   1. For room type at a venue

# Getting started
At root repository/project directory run:
```bash
./mvnw install && ./mvnw spring-boot:run -pl application
```